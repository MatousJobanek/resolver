package org.jboss.shrinkwrap.resolver.impl.maven.bootstrap;

import java.io.File;

import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.impl.maven.util.ValidationUtil;
import org.junit.Test;

/**
 * @author <a href="mailto:mjobanek@redhat.com">Matous Jobanek</a>
 */
public class MyBreakTestCase {


    @Test
    public void overrideGlobalSettings() {
        System.clearProperty(MavenSettingsBuilder.ALT_LOCAL_REPOSITORY_LOCATION);
        System.clearProperty(MavenSettingsBuilder.ALT_USER_SETTINGS_XML_LOCATION);
        System.setProperty(MavenSettingsBuilder.ALT_GLOBAL_SETTINGS_XML_LOCATION,
                           "target/settings/profiles/settings-break.xml");

        File[] files = Maven.configureResolver().resolve("org.jboss.shrinkwrap.test:test-deps-c:1.0.0").withTransitivity()
            .as(File.class);

        ValidationUtil
            .fromDependencyTree(new File("src/test/resources/dependency-trees/test-deps-c.tree")).validate(true,
                                                                                                           files);

        System.clearProperty(MavenSettingsBuilder.ALT_GLOBAL_SETTINGS_XML_LOCATION);

    }

}
