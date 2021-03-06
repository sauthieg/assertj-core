/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.core.api;

import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;

/**
 * Assertion methods applicable to <code>{@link Number}</code>s.
 * 
 * @param <S> the "self" type of this assertion class. Please read &quot;<a href="http://bit.ly/1IZIRcY"
 *          target="_blank">Emulating
 *          'self types' using Java Generics to simplify fluent API implementation</a>&quot; for more details.
 * @param <A> the type of the "actual" value.
 *
 * @author Alex Ruiz
 * @author Nicolas François
 * @author Mikhail Mazursky
 */
public interface NumberAssert<S extends NumberAssert<S, A>, A extends Number> {

  /**
   * Verifies that the actual value is equal to zero.
   * <p>
   * Example:
   * <pre><code class='java'> // assertions will pass
   * assertThat(0).isZero();
   * assertThat(0.0).isZero();
   *
   * // assertions will fail
   * assertThat(42).isZero();
   * assertThat(3.142).isZero();</code></pre>
   * 
   * @return this assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not equal to zero.
   */
  S isZero();

  /**
   * Verifies that the actual value is not equal to zero.
   * <p>
   * Example:
   * <pre><code class='java'> // assertions will pass
   * assertThat(42).isNotZero();
   * assertThat(3.142).isNotZero();
   *
   * // assertions will fail
   * assertThat(0).isNotZero();
   * assertThat(0.0).isNotZero();</code></pre>
   *
   * @return this assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to zero.
   */
  S isNotZero();

  /**
   * Verifies that the actual value is positive.
   * <p>
   * Example:
   * <pre><code class='java'> // assertions will pass
   * assertThat(42).isPositive();
   * assertThat(3.142).isPositive();
   *
   * // assertions will fail
   * assertThat(0).isPositive();
   * assertThat(-42).isPositive();</code></pre>
   * 
   * @return this assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not positive.
   */
  S isPositive();

  /**
   * Verifies that the actual value is negative.
   * <p>
   * Example:
   * <pre><code class='java'> // assertions will pass
   * assertThat(-42).isNegative();
   * assertThat(-3.124).isNegative();
   *
   * // assertions will fail
   * assertThat(0).isNegative();
   * assertThat(42).isNegative();</code></pre>
   * 
   * @return this assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not negative.
   */
  S isNegative();

  /**
   * Verifies that the actual value is non negative (positive or equal zero).
   * <p>
   * Example:
   * <pre><code class='java'> // assertions will pass
   * assertThat(42).isNotNegative();
   * assertThat(0).isNotNegative();
   *
   * // assertions will fail
   * assertThat(-42).isNotNegative();
   * assertThat(-3.124).isNotNegative();</code></pre>
   * 
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not non negative.
   */
  S isNotNegative();

  /**
   * Verifies that the actual value is non positive (negative or equal zero).
   * <p>
   * Example:
   * <pre><code class='java'> // assertions will pass
   * assertThat(-42).isNotPositive();
   * assertThat(0).isNotPositive();
   *
   * // assertions will fail
   * assertThat(42).isNotPositive();
   * assertThat(3.124).isNotPositive();</code></pre>
   * 
   * @return {@code this} assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not non positive.
   */
  S isNotPositive();

  /**
   * Verifies that the actual value is in [start, end] range (start included, end included).
   * <p>
   * Example:
   * <pre><code class='java'> // these assertions succeed ...
   * assertThat(12).isBetween(10, 14);
   * assertThat(12).isBetween(12, 14);
   * assertThat(12).isBetween(10, 12);
   * 
   * // ... but this one fails
   * assertThat(12).isBetween(14, 16);</code></pre>
   * 
   * @param start the start value (inclusive), expected not to be null.
   * @param end the end value (inclusive), expected not to be null.
   * @return this assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws NullPointerException if start value is {@code null}.
   * @throws NullPointerException if end value is {@code null}.
   * @throws AssertionError if the actual value is not in [start, end] range.
   */
  S isBetween(A start, A end);

  /**
   * Verifies that the actual value is in ]start, end[ range (start excluded, end excluded).
   * <p>
   * Example:
   * <pre><code class='java'> // this assertion succeeds ...
   * assertThat(12).isStrictlyBetween(10, 14);
   * 
   * // ... but these ones fail
   * assertThat(12).isStrictlyBetween(12, 14);
   * assertThat(12).isStrictlyBetween(10, 12);
   * assertThat(12).isStrictlyBetween(16, 18);</code></pre>
   * 
   * @param start the start value (exclusive), expected not to be null.
   * @param end the end value (exclusive), expected not to be null.
   * @return this assertion object.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws NullPointerException if start value is {@code null}.
   * @throws NullPointerException if end value is {@code null}.
   * @throws AssertionError if the actual value is not in ]start, end[ range.
   */
  S isStrictlyBetween(A start, A end);

  /**
   * Verifies that the actual number is close to the given one within the given offset.<br>
   * If difference is equal to offset value, assertion is considered valid.
   * <p>
   * Example with double:
   * <pre><code class='java'> // assertions will pass:
   * assertThat(8.1).isCloseTo(8.0, within(0.2));
   *
   * // you can use offset if you prefer
   * assertThat(8.1).isCloseTo(8.0, offset(0.2));
   *
   * // if difference is exactly equals to the offset (0.1), it's ok
   * assertThat(8.1).isCloseTo(8.0, within(0.1));
   *
   * // assertion will fail
   * assertThat(8.1).isCloseTo(8.0, within(0.01));</code></pre>
   *
   * @param expected the given number to compare the actual value to.
   * @param offset the given positive offset.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given offset is {@code null}.
   * @throws NullPointerException if the expected number is {@code null}.
   * @throws AssertionError if the actual value is not close to the given one.
   */
  S isCloseTo(A expected, Offset<A> offset);

  /**
   * Verifies that the actual number is not close to the given one within the given offset.<br>
   * If the difference is equal to the offset value, the assertion fails.
   * <p>
   * Example with double:
   * <pre><code class='java'> // assertions will pass:
   * assertThat(8.1).isNotCloseTo(8.0, byLessThan(0.01));
   *
   * // you can use offset if you prefer
   * assertThat(8.1).isNotCloseTo(8.0, offset(0.01));
   *
   * // assertions will fail
   * assertThat(8.1).isNotCloseTo(8.0, byLessThan(0.1));
   * assertThat(8.1).isNotCloseTo(8.0, byLessThan(0.2));</code></pre>
   *
   * @param expected the given number to compare the actual value to.
   * @param offset the given positive offset.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given offset is {@code null}.
   * @throws NullPointerException if the expected number is {@code null}.
   * @throws AssertionError if the actual value is close to the given one.
   * @since 2.6.0 / 3.6.0
   */
  S isNotCloseTo(A expected, Offset<A> offset);

  /**
   * Verifies that the actual number is close to the given one within the given percentage.<br>
   * If difference is equal to the percentage value, assertion is considered valid.
   * <p>
   * Example with double:
   * <pre><code class='java'> // assertions will pass:
   * assertThat(11.0).isCloseTo(10.0, withinPercentage(20));
   *
   * // if difference is exactly equals to the computed offset (1.0), it's ok
   * assertThat(11.0).isCloseTo(10.0, withinPercentage(10));
   *
   * // assertion will fail
   * assertThat(11.0).isCloseTo(10.0, withinPercentage(5));</code></pre>
   *
   * @param expected the given number to compare the actual value to.
   * @param percentage the given positive percentage.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given offset is {@code null}.
   * @throws NullPointerException if the expected number is {@code null}.
   * @throws AssertionError if the actual value is close to the given one.
   */
  S isCloseTo(A expected, Percentage percentage);

  /**
   * Verifies that the actual number is not close to the given one within the given percentage.<br>
   * If difference is equal to the percentage value, the assertion fails.
   * <p>
   * Example with double:
   * <pre><code class='java'> // assertions will pass:
   * assertThat(11.0).isNotCloseTo(10.0, withinPercentage(5));
   *
   * // assertions will fail
   * assertThat(11.0).isNotCloseTo(10.0, withinPercentage(10));
   * assertThat(11.0).isNotCloseTo(10.0, withinPercentage(20));</code></pre>
   *
   * @param expected the given number to compare the actual value to.
   * @param percentage the given positive percentage.
   * @return {@code this} assertion object.
   * @throws NullPointerException if the given offset is {@code null}.
   * @throws NullPointerException if the expected number is {@code null}.
   * @throws AssertionError if the actual value is not close to the given one.
   * @since 2.6.0 / 3.6.0
   */
  S isNotCloseTo(A expected, Percentage percentage);
}
