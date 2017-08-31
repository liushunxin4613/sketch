/*
 * Copyright (C) 2017 Peng fei Pan <sky@xiaopan.me>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.sketch.uri;

import android.content.Context;
import android.text.TextUtils;

import me.xiaopan.sketch.decode.AssetsDataSource;
import me.xiaopan.sketch.decode.DataSource;
import me.xiaopan.sketch.request.DownloadResult;
import me.xiaopan.sketch.request.UriInfo;

public class AssetUriModel implements UriModel {

    public static final String SCHEME = "asset://";

    public static String makeUri(String assetResName) {
        if (TextUtils.isEmpty(assetResName)) {
            return null;
        }
        return !assetResName.startsWith(SCHEME) ? SCHEME + assetResName : assetResName;
    }

    @Override
    public boolean match(String uri) {
        return !TextUtils.isEmpty(uri) && uri.startsWith(SCHEME);
    }

    @Override
    public String getUriContent(String uri) {
        return match(uri) ? uri.substring(SCHEME.length()) : uri;
    }

    @Override
    public String getDiskCacheKey(String uri) {
        return uri;
    }

    @Override
    public boolean isFromNet() {
        return false;
    }

    @Override
    public DataSource getDataSource(Context context, UriInfo uriInfo, DownloadResult downloadResult) {
        return new AssetsDataSource(context, uriInfo.getContent());
    }
}
