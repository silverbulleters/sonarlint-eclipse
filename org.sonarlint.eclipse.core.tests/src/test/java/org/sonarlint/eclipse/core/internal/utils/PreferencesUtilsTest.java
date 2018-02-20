/*
 * SonarLint for Eclipse
 * Copyright (C) 2015-2017 SonarSource SA
 * sonarlint@sonarsource.com
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
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarlint.eclipse.core.internal.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.sonarlint.eclipse.core.internal.resources.ExclusionItem;
import org.sonarlint.eclipse.core.internal.resources.ExclusionItem.Type;
import org.sonarlint.eclipse.core.internal.resources.SonarLintProperty;

import static org.assertj.core.api.Assertions.assertThat;

public class PreferencesUtilsTest {
  @Test
  public void should_serialize_exclusions() {
    List<ExclusionItem> list = new ArrayList<>();
    list.add(new ExclusionItem(Type.FILE, "file"));
    list.add(new ExclusionItem(Type.DIRECTORY, "dir"));

    String serialized = PreferencesUtils.serializeFileExclusions(list);
    List<ExclusionItem> desList = PreferencesUtils.deserializeFileExclusions(serialized);

    assertThat(desList).isEqualTo(list);
  }

  @Test
  public void should_serialize_extra_properties() {
    List<SonarLintProperty> list = new ArrayList<>();
    list.add(new SonarLintProperty("key1", "value1"));
    list.add(new SonarLintProperty("key2", "value2"));

    String serialized = PreferencesUtils.serializeExtraProperties(list);
    List<SonarLintProperty> desList = PreferencesUtils.deserializeExtraProperties(serialized);

    assertThat(desList).isEqualTo(list);
  }
}
