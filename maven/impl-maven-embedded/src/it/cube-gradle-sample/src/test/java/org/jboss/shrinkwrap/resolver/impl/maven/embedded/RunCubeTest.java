package org.jboss.shrinkwrap.resolver.impl.maven.embedded;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.arquillian.cube.CubeController;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.resolver.api.maven.embedded.EmbeddedMaven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author <a href="mailto:mjobanek@redhat.com">Matous Jobanek</a>
 */
@RunWith(Arquillian.class)
public class RunCubeTest {

    private static String GRADLE_SAMPLE_EMBEDDED_MAVEN = "gradle-sample-embedded-maven";

    @Test
    public void runCubeTest(@ArquillianResource CubeController cubeController) {

        EmbeddedMaven
            .forProject(System.getProperty("user.dir") + "/../../../../../pom.xml")
            .setGoals("install")
            //            .setLocalRepositoryDirectory(new File(System.getProperty("user.dir") + "/target/repository"))
            .setUserSettingsFile(new File("src/test/resources/settings.xml"))
            .build();

        cubeController.create(GRADLE_SAMPLE_EMBEDDED_MAVEN);
        cubeController.start(GRADLE_SAMPLE_EMBEDDED_MAVEN);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        cubeController.copyLog(GRADLE_SAMPLE_EMBEDDED_MAVEN, true, true, true, true, -1, bos);
        String log = new String(bos.toByteArray());
        System.out.println("log: " + log);

        cubeController.stop(GRADLE_SAMPLE_EMBEDDED_MAVEN);
        cubeController.destroy(GRADLE_SAMPLE_EMBEDDED_MAVEN);

        if (log.contains("FAILURE: Build failed with an exception.")){
            Assert.fail("The gradle build failed. For more information is the log.");
        }
    }
}
