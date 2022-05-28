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

import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.util.List;

/**
 * Tests if two numbers are equal.
 */
final class BooleanExpressionFunctionDelta<C extends ExpressionEvaluationContext> extends BooleanExpressionFunction<C> {

    /**
     * Type safe instance getter.
     */
    static <C extends ExpressionEvaluationContext> BooleanExpressionFunctionDelta<C> instance() {
        return Cast.to(INSTANCE);
    }

    /**
     * Singleton
     */
    private static final BooleanExpressionFunctionDelta<?> INSTANCE = new BooleanExpressionFunctionDelta<>();

    /**
     * Private ctor use singleton.
     */
    private BooleanExpressionFunctionDelta() {
        super("delta");
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<ExpressionNumber> NUMBER1 = ExpressionFunctionParameterName.with("number1")
            .required(ExpressionNumber.class);

    private final static ExpressionFunctionParameter<ExpressionNumber> NUMBER2 = ExpressionFunctionParameterName.with("number2")
            .required(ExpressionNumber.class);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = Lists.of(
            NUMBER1,
            NUMBER2
    );

    @Override
    public Boolean apply(final List<Object> parameters,
                         final C context) {
        this.checkParameterCount(parameters);

        return NUMBER1.getOrFail(parameters, 0)
                .equals(
                        NUMBER2.getOrFail(parameters, 1)
                );
    }
}
