package org.garrsolutions;

import io.quarkus.test.junit.NativeImageTest;
import org.garrsolutions.resource.NationResourceTest;

@NativeImageTest
public class NativeNationResourceIT extends NationResourceTest {

    // Execute the same tests but in native mode.
}