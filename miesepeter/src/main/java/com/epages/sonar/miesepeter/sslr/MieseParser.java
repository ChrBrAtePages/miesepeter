/*
 * SonarSource Language Recognizer
 * Copyright (C) 2010 SonarSource
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package com.epages.sonar.miesepeter.sslr;

import java.io.File;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.Grammar;
import com.sonar.sslr.impl.Parser;
public final class MieseParser {

  private static final Parser<Grammar> P = MieseParser.create();

  private MieseParser() {
  }

  public static Parser<Grammar> create() {
    return Parser.builder(MieseGrammar.create()).withLexer(MieseLexer.create()).build();
  }

  public static AstNode parseFile(File file ) {
//    File file = FileUtils.toFile(MieseParser.class.getResource(filePath));
    if (file == null || !file.exists()) {
      throw new AssertionError("The file \"wurdst\" does not exist.");
    }

    return P.parse(file);
  }

  public static AstNode parseString(String source) {
    return P.parse(source);
  }

}
