/**
 * Copyright (C) 2023 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.intersmash.tools.provision.openshift.operator.keycloak.keycloak.spec;

import io.fabric8.kubernetes.api.model.ResourceRequirements;

/**
 * Resources (Requests and Limits) for KeycloakDeployment.
 */
public final class KeycloakDeploymentSpecBuilder {
	private ResourceRequirements resources;
	private ExperimentalSpec experimental;

	/**
	 * Set the Resources (Requests and Limits) for the Pods.
	 *
	 * @param resources The Resources (Requests and Limits) for the Pods
	 * @return this
	 */
	public KeycloakDeploymentSpecBuilder resources(ResourceRequirements resources) {
		this.resources = resources;
		return this;
	}

	/**
	 * Experimental section
	 * NOTE: This section might change or get removed without any notice. It may also cause the deployment to behave
	 * in an unpredictable fashion. Please use with care.
	 *
	 * @param experimental The experimental section definition
	 * @return this
	 */
	public KeycloakDeploymentSpecBuilder experimental(ExperimentalSpec experimental) {
		this.experimental = experimental;
		return this;
	}

	public KeycloakDeploymentSpec build() {
		KeycloakDeploymentSpec keycloakDeploymentSpec = new KeycloakDeploymentSpec();
		keycloakDeploymentSpec.setResources(resources);
		keycloakDeploymentSpec.setExperimental(experimental);
		return keycloakDeploymentSpec;
	}
}
