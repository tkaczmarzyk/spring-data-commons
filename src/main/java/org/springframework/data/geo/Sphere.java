/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.geo;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.util.Assert;

/**
 * Represents a geospatial sphere value.
 * 
 * @author Thomas Darimont
 * @since 1.8
 */
public class Sphere {

	private final Point center;
	private final double radius;

	/**
	 * Creates a Sphere around the given center {@link Point} with the given radius.
	 * 
	 * @param center must not be {@literal null}.
	 * @param radius must not be {@literal null}.
	 */
	@PersistenceConstructor
	public Sphere(Point center, double radius) {

		Assert.notNull(center);
		Assert.isTrue(radius >= 0, "Radius must not be negative!");

		this.center = center;
		this.radius = radius;
	}

	/**
	 * Creates a Sphere from the given {@link Circle}.
	 * 
	 * @param circle
	 */
	public Sphere(Circle circle) {
		this(circle.getCenter(), circle.getRadius());
	}

	/**
	 * Returns the center of the {@link Circle}.
	 * 
	 * @return will never be {@literal null}.
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * Returns the radius of the {@link Circle}.
	 * 
	 * @return
	 */
	public double getRadius() {
		return radius;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Sphere [center=%s, radius=%f]", center, radius);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || !(obj instanceof Sphere)) {
			return false;
		}

		Sphere that = (Sphere) obj;

		return this.center.equals(that.center) && this.radius == that.radius;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 17;
		result += 31 * center.hashCode();
		result += 31 * radius;
		return result;
	}
}
