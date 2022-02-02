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

package org.andresoviedo.android_3d_model_engine.services.collada.entities;

import java.nio.FloatBuffer;

/**
 * This object contains all the mesh data for an animated model that is to be loaded into the VAO.
 * 
 * @author Karl
 *
 */
public class MeshData {

	private static final int DIMENSIONS = 3;

	private String id;
	private float[] vertices;
	private float[] textureCoords;
	private float[] normals;
	private float[] color;
	private FloatBuffer colorsBuffer;
	private String texture;
	private int[] indices;
	private int[] jointIds;
	private float[] vertexWeights;

	public MeshData(String id, float[] vertices, float[] textureCoords, float[] normals, float[] color, FloatBuffer colorsBuffer, String texture, int[] indices,
					int[] jointIds, float[] vertexWeights) {
		this.id = id;
		this.vertices = vertices;
		this.textureCoords = textureCoords;
		this.normals = normals;
		this.color = color;
		this.colorsBuffer = colorsBuffer;
		this.texture = texture;
		this.indices = indices;
		this.jointIds = jointIds;
		this.vertexWeights = vertexWeights;
	}

	public int[] getJointIds() {
		return jointIds;
	}
	
	public float[] getVertexWeights(){
		return vertexWeights;
	}

	public float[] getVertices() {
		return vertices;
	}

	public float[] getTextureCoords() {
		return textureCoords;
	}

	public float[] getNormals() {
		return normals;
	}

	public float[] getColor() {
		return color;
	}

	public FloatBuffer getColorsBuffer(){
		return colorsBuffer;
	}

	public int[] getIndices() {
		return indices;
	}

	public int getVertexCount() {
		return vertices.length / DIMENSIONS;
	}

	public String getId() {
		return id;
	}

	public String getTexture() {
		return texture;
	}
}
