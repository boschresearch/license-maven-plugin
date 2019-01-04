package org.codehaus.mojo.license.model;

/*
 * #%L
 * License Maven Plugin
 * %%
 * Copyright (C) 2010 - 2011 Codehaus
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.apache.maven.artifact.Artifact;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the license information for a single project/dependency
 *
 * @author pgier
 * @since 1.0
 */
public class ProjectLicenseInfo
{
    private String groupId;

    private String artifactId;

    private String version;

    private List<ProjectLicense> licenses = new ArrayList<>();

    private String licenseResolutionResult;

    public String getLicenseResolutionResult()
    {
        return licenseResolutionResult;
    }

    public void setLicenseResolutionResult( String licenseResolutionResult )
    {
        this.licenseResolutionResult = licenseResolutionResult;
    }

    /**
     * Default constructor.
     */
    public ProjectLicenseInfo()
    {

    }

    public ProjectLicenseInfo( String groupId, String artifactId, String version )
    {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    public String getGroupId()
    {
        return groupId;
    }

    public void setGroupId( String groupId )
    {
        this.groupId = groupId;
    }

    public String getArtifactId()
    {
        return artifactId;
    }

    public void setArtifactId( String artifactId )
    {
        this.artifactId = artifactId;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion( String version )
    {
        this.version = version;
    }

    public List<ProjectLicense> getLicenses()
    {
        return licenses;
    }

    public void setLicenses( List<ProjectLicense> licenses )
    {
        this.licenses = licenses;
    }

    public void addLicense( ProjectLicense license )
    {
        licenses.add( license );
    }

    /**
     * The unique ID for the project
     *
     * @return String containing "groupId:artifactId"
     */
    public String getId()
    {
        return groupId + ":" + artifactId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals( Object compareTo )
    {
        if ( compareTo instanceof ProjectLicenseInfo )
        {
            ProjectLicenseInfo compare = (ProjectLicenseInfo) compareTo;
            if ( groupId.equals( compare.getGroupId() ) && artifactId.equals( compare.getArtifactId() ) )
            {
                return true;
            }
        }
        if ( compareTo instanceof Artifact )
        {
            Artifact compare = (Artifact) compareTo;
            if ( groupId.equals( compare.getGroupId() ) && artifactId.equals( compare.getArtifactId() ) )
            {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        return getId().hashCode();
    }

}
