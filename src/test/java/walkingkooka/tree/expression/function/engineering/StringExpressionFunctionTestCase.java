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

import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.ExpressionFunction;

import java.math.MathContext;
import java.util.List;
import java.util.Locale;

public abstract class StringExpressionFunctionTestCase<F extends ExpressionFunction<String, ExpressionEvaluationContext>> extends ExpressionFunctionTestCase<F, String> {

    final static ExpressionNumberKind KIND = ExpressionNumberKind.DEFAULT;

    StringExpressionFunctionTestCase() {
        super();
    }

    final void applyAndCheck3(final F function,
                              final List<Object> parameters,
                              final String result) {
        this.applyAndCheck2(
                function,
                parameters,
                this.createContext(),
                result
        );
    }

    // ExpressionFunctionTesting........................................................................................

    @Override
    public final ExpressionEvaluationContext createContext() {
        return new FakeExpressionEvaluationContext() {

            @Override
            public Locale locale() {
                return Locale.forLanguageTag("EN-AU");
            }

            @Override
            public ExpressionNumberKind expressionNumberKind() {
                return KIND;
            }

            @Override
            public MathContext mathContext() {
                return MathContext.DECIMAL32;
            }

            @Override
            public char decimalSeparator() {
                return '.';
            }

            @Override
            public char negativeSign() {
                return '-';
            }

            @Override
            public char positiveSign() {
                return '+';
            }
        };
    }

    @Override
    public final String typeNamePrefix() {
        return StringExpressionFunction.class.getSimpleName();
    }
}
