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
package org.jboss.intersmash.tools.provision.openshift.operator.wildfly;

import org.jboss.intersmash.tools.provision.openshift.operator.resources.OpenShiftResource;
import org.jboss.intersmash.tools.provision.openshift.operator.wildfly.spec.WildFlyServerSpec;
import org.jboss.intersmash.tools.provision.openshift.operator.wildfly.status.WildFlyServerStatus;

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
 * <a href="https://github.com/wildfly/wildfly-operator/blob/master/doc/apis.adoc#wildflyserver">WildFlyServer</a>
 * defines a custom WildFly resource.
 * <p>
 * Service object to enable operator manipulation via OpenShift client.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Group("wildfly.org")
@Version("v1alpha1")
public class WildFlyServer extends CustomResource implements OpenShiftResource<WildFlyServer> {

	/**
	 * Standard object’s metadata.
	 */
	private ObjectMeta metadata;

	/**
	 * Specification of the desired behaviour of the WildFly deployment.
	 */
	private WildFlyServerSpec spec;

	/**
	 * Most recent observed status of the WildFly deployment. Read-only.
	 */
	private WildFlyServerStatus status;

	@Override
	public WildFlyServer load(WildFlyServer loaded) {
		this.setMetadata(loaded.getMetadata());
		this.setSpec(loaded.getSpec());
		return this;
	}
}
