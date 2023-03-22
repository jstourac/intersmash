/*
 * Hyperfoil Controller API
 * Hyperfoil Controller API
 *
 * The version of the OpenAPI document: 0.5
 * Contact: rvansa@redhat.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.jboss.intersmash.tools.provision.openshift.operator.hyperfoil.client.v05.invoker.auth;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.jboss.intersmash.tools.provision.openshift.operator.hyperfoil.client.v05.invoker.ApiException;
import org.jboss.intersmash.tools.provision.openshift.operator.hyperfoil.client.v05.invoker.Pair;

import okhttp3.Credentials;

public class HttpBasicAuth implements Authentication {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams, Map<String, String> cookieParams,
			String payload, String method, URI uri) throws ApiException {
		if (username == null && password == null) {
			return;
		}
		headerParams.put("Authorization", Credentials.basic(
				username == null ? "" : username,
				password == null ? "" : password));
	}
}