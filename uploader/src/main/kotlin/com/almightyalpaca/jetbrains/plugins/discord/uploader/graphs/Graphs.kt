/*
 * Copyright 2017-2020 Aljoscha Grebe
 * Copyright 2017-2020 Axel JOLY (Azn9) - https://github.com/Azn9
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.almightyalpaca.jetbrains.plugins.discord.uploader.graphs

import com.almightyalpaca.jetbrains.plugins.discord.icons.source.classpath.ClasspathSource
import com.almightyalpaca.jetbrains.plugins.discord.uploader.utils.getIcons
import kotlinx.coroutines.runBlocking
import java.nio.file.Files
import java.nio.file.Paths

@Suppress("BlockingMethodInNonBlockingContext")
fun main() = runBlocking {
    val source = ClasspathSource("discord", retry = false)
    val languages = source.getLanguages()
    val themes = source.getThemes()

    val graphs = Paths.get("build/graphs/")
    Files.createDirectories(graphs)

    for (theme in themes.keys) {
        val icons = source.getIcons(theme)

        val exporter = DotGraphExporter(languages, icons)

        val path = graphs.resolve("$theme.dot")

        Files.newBufferedWriter(path).use { writer ->
            exporter.writeTo(writer)
        }
    }
}
