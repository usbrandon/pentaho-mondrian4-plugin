package bi.meteorite.plugin;

import org.pentaho.platform.api.engine.IPluginLifecycleListener;
import org.pentaho.platform.api.engine.PluginLifecycleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.webdetails.cpf.PentahoPluginEnvironment;
import pt.webdetails.cpf.repository.api.IContentAccessFactory;
import pt.webdetails.cpf.repository.api.IReadAccess;

/**
 * Created by bugg on 13/01/15.
 */
public class CM4PluginLifecycleListener implements IPluginLifecycleListener {

  private static final Logger log = LoggerFactory.getLogger(CM4PluginLifecycleListener.class);

  public void init() throws PluginLifecycleException {
    IContentAccessFactory contentAccessFactory = PentahoPluginEnvironment.getInstance().getContentAccessFactory();
   // String mondrianPropsFilename = "mondrian.properties"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    final ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
    final ClassLoader altLoader = this.getClass().getClassLoader();


    try {
      if (altLoader != origLoader) {
        Thread.currentThread().setContextClassLoader(altLoader);
      }

      IReadAccess mf = contentAccessFactory.getPluginSystemReader("../mondrian");
     /* if (mf.fileExists(mondrianPropsFilename)) {
        IBasicFile bf = mf.fetchFile(mondrianPropsFilename);
        MondrianProperties.instance().load(bf.getContents());
        log.debug("Loaded mondrian properties file: " + mondrianPropsFilename);

      } else {
        log.debug("Cannot find mondrian properties file: "+  mondrianPropsFilename);
      }*/
    } catch (Exception ioe) {
      //log.error("Loading mondrian properties file failed: " + mondrianPropsFilename,ioe);
    } finally {
      Thread.currentThread().setContextClassLoader(origLoader);
    }
  }

  public void loaded() throws PluginLifecycleException {
    // TODO Auto-generated method stub

  }

  public void unLoaded() throws PluginLifecycleException {
    // TODO Auto-generated method stub

  }
}
