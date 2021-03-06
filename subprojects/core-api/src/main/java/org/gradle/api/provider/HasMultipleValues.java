/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.api.provider;

import org.gradle.api.Incubating;

import javax.annotation.Nullable;

/**
 * Represents a property whose value can be set using multiple elements of type {@link T}, such as a collection property.
 *
 * <p><b>Note:</b> This interface is not intended for implementation by build script or plugin authors. You can use the factory methods on {@link org.gradle.api.model.ObjectFactory} to create instances of this interface.
 *
 * @param <T> the type of elements.
 * @since 4.5
 */
@Incubating
public interface HasMultipleValues<T> {
    /**
     * Sets the value of the property the elements of the given iterable. This property will track the value of the iterable and query its value each time the value of this property is queried.
     *
     * <p>This method can also be used to clear the value of the property, by passing {@code null} as the value.
     *
     * @param elements The elements, can be null.
     */
    void set(@Nullable Iterable<? extends T> elements);

    /**
     * Sets the property to have the same value of the given provider. This property will track the value of the provider and query its value each time the value of this property is queried. When the provider has no value, this property will also have no value.
     *
     * @param provider Provider of the elements.
     */
    void set(Provider<? extends Iterable<? extends T>> provider);

    /**
     * Adds an element to the property value.
     *
     * @param element The element
     */
    void add(T element);

    /**
     * Adds an element to the property value.
     *
     * <p>The given provider will be queried when the value of this property is queried.
     * This property will have no value when the given provider has no value.
     *
     * @param provider The provider of an element
     */
    void add(Provider<? extends T> provider);

    /**
     * Adds zero or more elements to the property value.
     *
     * @param elements The elements to add
     * @since 4.10
     */
    void addAll(T... elements);

    /**
     * Adds zero or more elements to the property value.
     *
     * <p>The given iterable will be queried when the value of this property is queried.
     *
     * @param elements The elements to add.
     * @since 4.10
     */
    void addAll(Iterable<? extends T> elements);

    /**
     * Adds zero or more elements to the property value.
     *
     * <p>The given provider will be queried when the value of this property is queried.
     * This property will have no value when the given provider has no value.
     *
     * @param provider Provider of elements
     */
    void addAll(Provider<? extends Iterable<? extends T>> provider);
}
