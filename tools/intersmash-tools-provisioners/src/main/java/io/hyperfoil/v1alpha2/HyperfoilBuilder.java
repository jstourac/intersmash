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
package io.hyperfoil.v1alpha2;

import io.fabric8.kubernetes.api.model.ObjectMeta;

public final class HyperfoilBuilder {
	private String name;

	//TODO: complete with all hyperfoil ino

	/**
	 * Initialize the {@link HyperfoilBuilder} with given resource name.
	 *
	 * @param name resource object name
	 */
	public HyperfoilBuilder(String name) {
		this.name = name;
	}

	public Hyperfoil build() {
		Hyperfoil hyperfoil = new Hyperfoil();
		hyperfoil.setMetadata(new ObjectMeta());
		hyperfoil.getMetadata().setName(name);

		HyperfoilSpec spec = new HyperfoilSpec();
		hyperfoil.setSpec(spec);

		return hyperfoil;
	}
}
