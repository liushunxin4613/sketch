/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
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

package me.xiaopan.android.imageloader.task.display;

import me.xiaopan.android.imageloader.util.ImageSize;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

/**
 * 显示请求
 */
public class DisplayRequest {
	private String id;	//ID
	private String name;	//名称，用于在输出log时区分不同的请求
	/**
	 * 支持以下5种Uri
	 * <blockquote>String imageUri = "http://site.com/image.png"; // from Web
	 * <br>String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
	 * <br>String imageUri = "content://media/external/audio/albumart/13"; // from content provider
	 * <br>String imageUri = "assets://image.png"; // from assets
	 * <br>String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)
	 * </blockquote>
	 */
	private String imageUri;
	private DisplayOptions displayOptions;	//显示选项
	private ImageSize targetSize;	//目标尺寸
	
	private ImageViewAware imageViewAware;
	private DisplayListener displayListener;
	
	private DisplayRequest(ImageViewAware imageViewAware) {
		this.imageViewAware = imageViewAware;
	}

	/**
	 * 获取ID
	 * @return ID
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * 设置ID
	 * @param id ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 获取Uri，支持以下5种Uri
	 * <blockquote>String imageUri = "http://site.com/image.png"; // from Web
	 * <br>String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
	 * <br>String imageUri = "content://media/external/audio/albumart/13"; // from content provider
	 * <br>String imageUri = "assets://image.png"; // from assets
	 * <br>String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)
	 * </blockquote>
	 * @return
	 */
	public String getImageUri() {
		return imageUri;
	}

	/**
	 * 设置Uri，支持以下5种Uri
	 * <blockquote>String imageUri = "http://site.com/image.png"; // from Web
	 * <br>String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
	 * <br>String imageUri = "content://media/external/audio/albumart/13"; // from content provider
	 * <br>String imageUri = "assets://image.png"; // from assets
	 * <br>String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)
	 * </blockquote>
	 * @param imageUri
	 */
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	/**
	 * 获取名称，用于在输出log时区分不同的请求
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置名称，用于在输出log时区分不同的请求
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取显示选项
	 * @return
	 */
	public DisplayOptions getDisplayOptions() {
		return displayOptions;
	}

	/**
	 * 设置显示选项
	 * @param displayOptions
	 */
	public void setDisplayOptions(DisplayOptions displayOptions) {
		this.displayOptions = displayOptions;
	}
	
	/**
	 * 获取目标尺寸
	 * @return
	 */
	public ImageSize getTargetSize() {
		return targetSize;
	}

	/**
	 * 设置目标尺寸
	 * @param targetSize
	 */
	public void setTargetSize(ImageSize targetSize) {
		this.targetSize = targetSize;
	}
	
	/**
	 * 获取ImageViewAware
	 * @return
	 */
	public ImageViewAware getImageViewAware() {
		return imageViewAware;
	}

	/**
	 * 获取显示监听器
	 * @return
	 */
	public DisplayListener getDisplayListener() {
		return displayListener;
	}

	/**
	 * 设置显示监听器
	 * @param imageLoadListener
	 */
	public void setDisplayListener(DisplayListener imageLoadListener) {
		this.displayListener = imageLoadListener;
	}

	public static class Builder{
		DisplayRequest request;
		
		public Builder(ImageViewAware imageViewAware){
			request = new DisplayRequest(imageViewAware);
		}
		
		/**
		 * 设置ID
		 * @param id ID
		 */
		public Builder setId(String id) {
			request.setId(id);
			return this;
		}
		
		/**
		 * 设置Uri，支持以下5种Uri
		 * <blockquote>String imageUri = "http://site.com/image.png"; // from Web
		 * <br>String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
		 * <br>String imageUri = "content://media/external/audio/albumart/13"; // from content provider
		 * <br>String imageUri = "assets://image.png"; // from assets
		 * <br>String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)
		 * </blockquote>
		 * @param imageUri
		 */
		public Builder setImageUri(String imageUri) {
			request.setImageUri(imageUri);
			return this;
		}

		/**
		 * 设置名称，用于在输出log时区分不同的请求
		 * @param name
		 */
		public Builder setName(String name) {
			request.setName(name);
			return this;
		}
		
		/**
		 * 设置显示选项
		 * @param displayOptions
		 */
		public Builder setDisplayOptions(DisplayOptions displayOptions) {
			request.setDisplayOptions(displayOptions);
			return this;
		}
		
		/**
		 * 设置目标尺寸
		 * @param targetSize
		 */
		public Builder setTargetSize(ImageSize targetSize) {
			request.setTargetSize(targetSize);
			return this;
		}
		
		/**
		 * 设置显示监听器
		 * @param displayListener
		 * @return
		 */
		public Builder setDisplayListener(DisplayListener displayListener) {
			request.setDisplayListener(displayListener);
			return this;
		}
		
		public DisplayRequest build(){
			return request;
		}
	}
	
	/**
	 * 显示监听器
	 */
	public interface DisplayListener {
		public void onStarted(String imageUri, ImageView imageView);
		public void onFailed(String imageUri, ImageView imageView);
		public void onComplete(String imageUri, ImageView imageView, BitmapDrawable drawable);
		public void onCancelled(String imageUri, ImageView imageView);
	}
}
