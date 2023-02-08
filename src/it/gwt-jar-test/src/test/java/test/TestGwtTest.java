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

package test;

import com.google.gwt.junit.client.GWTTestCase;

import walkingkooka.collect.list.Lists;
import walkingkooka.j2cl.locale.LocaleAware;
import walkingkooka.tree.expression.ExpressionNumberKind;
import walkingkooka.tree.expression.FakeExpressionEvaluationContext;
import walkingkooka.tree.expression.function.engineering.EngineeringExpressionFunctions;

import java.math.MathContext;
import java.util.Locale;

@LocaleAware
public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
                1,
                1
        );
    }

    public void testBin2Dec() {
        assertEquals(
                "5",
                EngineeringExpressionFunctions.bin2dec()
                        .apply(
                                Lists.of(
                                        "101"
                                ),
                                new FakeExpressionEvaluationContext() {

                                    @Override
                                    public Locale locale() {
                                        return Locale.forLanguageTag("EN-AU");
                                    }

                                    @Override
                                    public ExpressionNumberKind expressionNumberKind() {
                                        return ExpressionNumberKind.BIG_DECIMAL;
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
                                }
                        )
        );
    }
}
