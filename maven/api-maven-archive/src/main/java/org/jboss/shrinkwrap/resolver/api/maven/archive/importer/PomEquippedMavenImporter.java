/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.resolver.api.maven.archive.importer;

import org.jboss.shrinkwrap.api.Assignable;
import org.jboss.shrinkwrap.resolver.api.maven.ScopeType;
import org.jboss.shrinkwrap.resolver.api.maven.archive.assembler.ArchiveMavenAssembler;
import org.jboss.shrinkwrap.resolver.api.maven.strategy.MavenResolutionStrategy;
import org.jboss.shrinkwrap.resolver.api.maven.archive.assembler.PomlessArchiveMavenAssembler;

/**
 * Instance of {@link MavenImporter} that has configuration from a POM file loaded
 * <p><b>
 * This API is deprecated, please use {@link ArchiveMavenAssembler} API and {@link PomlessArchiveMavenAssembler} instead
 * </b></p>
 *
 * @author <a href="kpiwko@redhat.com">Karel Piwko</a>
 *
 */
@Deprecated
public interface PomEquippedMavenImporter extends Assignable {

    /**
     * Build an archive based on metadata previously loaded from a Project Object Model file. Packages following scopes:
     * {@link ScopeType#COMPILE}, {@link ScopeType#IMPORT}, {@link ScopeType#RUNTIME}, {@link ScopeType#SYSTEM}
     * <p><b>
     * This API is deprecated, please use {@link ArchiveMavenAssembler} API instead
     * </b></p>
     *
     * @return This modified {@link MavenImporter} instance with a built archive based on metadata previously loaded
     * from a Project Object Model file.
     */
    @Deprecated
    PomEquippedMavenImporter importBuildOutput();

    /**
     * Build an archive based on metadata previously loaded from a Project Object Model file. Uses passed strategy to define
     * dependencies to be packaged into the archive.
     * <p><b>
     * This API is deprecated, please use {@link ArchiveMavenAssembler} API instead
     * </b></p>
     *
     * @param strategy The strategy defining objects to be packaged
     * @return This modified {@link MavenImporter} instance with a built archive based on metadata previously loaded
     * from a Project Object Model file.
     * @throws IllegalArgumentException If no strategy is specified
     */
    @Deprecated
    PomEquippedMavenImporter importBuildOutput(MavenResolutionStrategy strategy) throws IllegalArgumentException;

}
