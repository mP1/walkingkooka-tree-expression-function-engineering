/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.engineering;

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionEvaluationContext;

public final class NumberExpressionFunctionBitAndOrXorTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionBitAndOrXor<ExpressionEvaluationContext>> {

    // bitAnd........................................................................................................

    @Test
    public void testBitAndWholeNumbers() {
        this.bitAndAndCheck(
                3,
                6,
                3 & 6
        );
    }

    @Test
    public void testBitAndDecimals() {
        this.bitAndAndCheck(
                3.5,
                6.5,
                3 & 6
        );
    }

    private void bitAndAndCheck(final Number value1,
                                final Number value2,
                                final Number expected) {
        this.applyAndCheck3(
                NumberExpressionFunctionBitAndOrXor.bitAnd(),
                value1,
                value2,
                expected
        );
    }

    // bitOr........................................................................................................

    @Test
    public void testBitOrWholeNumbers() {
        this.bitOrAndCheck(
                3,
                6,
                3 | 6
        );
    }

    @Test
    public void testBitOrDecimals() {
        this.bitOrAndCheck(
                3.5,
                6.5,
                3 | 6
        );
    }

    private void bitOrAndCheck(final Number value1,
                               final Number value2,
                               final Number expected) {
        this.applyAndCheck3(
                NumberExpressionFunctionBitAndOrXor.bitOr(),
                value1,
                value2,
                expected
        );
    }

    // bitXor........................................................................................................

    @Test
    public void testBitXorWholeNumbers() {
        this.bitXorAndCheck(
                3,
                6,
                3 ^ 6
        );
    }

    @Test
    public void testBitXorDecimals() {
        this.bitXorAndCheck(
                3.5,
                6.5,
                3 ^ 6
        );
    }

    private void bitXorAndCheck(final Number value1,
                                final Number value2,
                                final Number expected) {
        this.applyAndCheck3(
                NumberExpressionFunctionBitAndOrXor.bitXor(),
                value1,
                value2,
                expected
        );
    }
    // helper...........................................................................................................

    private void applyAndCheck3(final NumberExpressionFunctionBitAndOrXor<ExpressionEvaluationContext> function,
                                final Number value1,
                                final Number value2,
                                final Number expected) {
        this.applyAndCheck(
                function,
                Lists.of(
                        KIND.create(value1),
                        KIND.create(value2)
                ),
                this.createContext(),
                KIND.create(expected)
        );
    }

    // toString........................................................................................................

    @Test
    public void testToStringBitAnd() {
        this.toStringAndCheck(
                NumberExpressionFunctionBitAndOrXor.bitAnd(),
                "bit-and"
        );
    }

    @Test
    public void testToStringBitOr() {
        this.toStringAndCheck(
                NumberExpressionFunctionBitAndOrXor.bitOr(),
                "bit-or"
        );
    }

    @Test
    public void testToStringBitXor() {
        this.toStringAndCheck(
                NumberExpressionFunctionBitAndOrXor.bitXor(),
                "bit-xor"
        );
    }

    @Override
    public NumberExpressionFunctionBitAndOrXor<ExpressionEvaluationContext> createBiFunction() {
        return NumberExpressionFunctionBitAndOrXor.bitAnd();
    }

    @Override
    public Class<NumberExpressionFunctionBitAndOrXor<ExpressionEvaluationContext>> type() {
        return Cast.to(NumberExpressionFunctionBitAndOrXor.class);
    }
}
