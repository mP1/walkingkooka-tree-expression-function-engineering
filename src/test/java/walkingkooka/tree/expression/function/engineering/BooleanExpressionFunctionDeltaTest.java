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
import walkingkooka.tree.expression.ExpressionNumberKind;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class BooleanExpressionFunctionDeltaTest extends BooleanExpressionFunctionTestCase<BooleanExpressionFunctionDelta<ExpressionEvaluationContext>> {

    private final static ExpressionNumberKind KIND = ExpressionNumberKind.DEFAULT;

    @Test
    public void testNonNumberParameterFails() {
        assertThrows(
                ClassCastException.class,
                () -> {
                    this.apply2(
                            "Not-a-number",
                            KIND.create(2)
                    );
                }
        );
    }

    @Test
    public void testEqual() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(125.5),
                        KIND.create(125.5)
                ),
                true
        );
    }

    @Test
    public void testDifferent() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(123),
                        KIND.create(456)
                ),
                false
        );
    }

    @Test
    public void testToString() {
        this.toStringAndCheck(
                this.createBiFunction(),
                "delta"
        );
    }

    @Override
    public BooleanExpressionFunctionDelta<ExpressionEvaluationContext> createBiFunction() {
        return BooleanExpressionFunctionDelta.instance();
    }

    @Override
    public Class<BooleanExpressionFunctionDelta<ExpressionEvaluationContext>> type() {
        return Cast.to(BooleanExpressionFunctionDelta.class);
    }
}
