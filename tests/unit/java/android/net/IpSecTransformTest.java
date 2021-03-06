/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.os.Build;

import androidx.test.filters.SmallTest;

import com.android.testutils.DevSdkIgnoreRule;
import com.android.testutils.DevSdkIgnoreRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

/** Unit tests for {@link IpSecTransform}. */
@SmallTest
@RunWith(DevSdkIgnoreRunner.class)
@DevSdkIgnoreRule.IgnoreUpTo(Build.VERSION_CODES.R)
public class IpSecTransformTest {

    @Test
    public void testCreateTransformCopiesConfig() {
        // Create a config with a few parameters to make sure it's not empty
        IpSecConfig config = new IpSecConfig();
        config.setSourceAddress("0.0.0.0");
        config.setDestinationAddress("1.2.3.4");
        config.setSpiResourceId(1984);

        IpSecTransform preModification = new IpSecTransform(null, config);

        config.setSpiResourceId(1985);
        IpSecTransform postModification = new IpSecTransform(null, config);

        assertNotEquals(preModification, postModification);
    }

    @Test
    public void testCreateTransformsWithSameConfigEqual() {
        // Create a config with a few parameters to make sure it's not empty
        IpSecConfig config = new IpSecConfig();
        config.setSourceAddress("0.0.0.0");
        config.setDestinationAddress("1.2.3.4");
        config.setSpiResourceId(1984);

        IpSecTransform config1 = new IpSecTransform(null, config);
        IpSecTransform config2 = new IpSecTransform(null, config);

        assertEquals(config1, config2);
    }
}
