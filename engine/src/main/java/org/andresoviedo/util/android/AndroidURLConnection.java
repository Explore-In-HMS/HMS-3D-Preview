// Copyright 2022. Explore in HMS. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

// http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.andresoviedo.util.android;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class AndroidURLConnection extends URLConnection {

    private InputStream stream;

    public AndroidURLConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException
    {
        if (stream == null) {
            try {
                stream = ContentUtils.getInputStream(url.toURI());
            } catch (URISyntaxException e) {
                Log.e("Handler", e.getMessage(), e);
                throw new IOException("Error opening stream " + url + ". " + e.getMessage());
            }
        }
    }

    @Override
    public InputStream getInputStream() throws IOException {
        connect();
        return stream;
    }
}
