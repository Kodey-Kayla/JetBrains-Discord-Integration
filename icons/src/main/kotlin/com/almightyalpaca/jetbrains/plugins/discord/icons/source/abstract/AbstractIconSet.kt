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

package com.almightyalpaca.jetbrains.plugins.discord.icons.source.abstract

import com.almightyalpaca.jetbrains.plugins.discord.icons.source.IconSet
import com.almightyalpaca.jetbrains.plugins.discord.icons.source.Theme

abstract class AbstractIconSet(
    override val theme: Theme,
    override val applicationId: Long?,
    private val icons: Set<String>,
    override val applicationName: String
) : IconSet, Set<String> by icons {
    override fun toString(): String {
        return "AbstractIconSet(theme=$theme, applicationId=$applicationId, icons=$icons, applicationName='$applicationName')"
    }
}
