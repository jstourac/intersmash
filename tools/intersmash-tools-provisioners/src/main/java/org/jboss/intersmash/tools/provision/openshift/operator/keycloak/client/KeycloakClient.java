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
package org.jboss.intersmash.tools.provision.openshift.operator.keycloak.client;

import org.jboss.intersmash.tools.provision.openshift.operator.keycloak.client.spec.KeycloakClientSpec;
import org.jboss.intersmash.tools.provision.openshift.operator.keycloak.client.status.KeycloakClientStatus;
import org.jboss.intersmash.tools.provision.openshift.operator.resources.OpenShiftResource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * https://access.redhat.com/documentation/en-us/red_hat_single_sign-on/7.4/html/server_installation_and_configuration_guide/operator#client-cr
 *
 * https://github.com/keycloak/keycloak-operator/blob/master/pkg/apis/keycloak/v1alpha1/keycloakbackup_types.go
 * https://github.com/keycloak/keycloak-operator/blob/master/deploy/crds/keycloak.org_keycloakbackups_crd.yaml
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Group("keycloak.org")
@Version("v1alpha1")
public class KeycloakClient extends CustomResource implements OpenShiftResource<KeycloakClient> {
	/**
	 * Standard object’s metadata.
	 */
	private ObjectMeta metadata;

	/**
	 * KeycloakClientSpec defines the desired state of KeycloakClient.
	 */
	private KeycloakClientSpec spec;

	/**
	 * KeycloakClientStatus defines the observed state of KeycloakClient
	 */
	private KeycloakClientStatus status;

	@Override
	public KeycloakClient load(KeycloakClient loaded) {
		this.setMetadata(loaded.getMetadata());
		this.setSpec(loaded.getSpec());
		return this;
	}
}
