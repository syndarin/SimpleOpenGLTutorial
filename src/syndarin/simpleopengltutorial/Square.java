package syndarin.simpleopengltutorial;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class Square {
	
	private FloatBuffer verticesBuffer;
	private ByteBuffer colorBuffer;
	private ByteBuffer indexesBuffer;

	private float[] vertices = {
			-1f, -1f,
			 1f, -1f,
			-1f,  1f,
			 1f,  1f
	};
	
	private byte maxColor = (byte)255;
	
	private byte[] colors = {
			maxColor, maxColor, 0, maxColor,
			0, maxColor, maxColor, maxColor,
			0, 0, 0, maxColor,
			maxColor, 0, maxColor, maxColor
	};
	
	private byte[] indexes = {
			0, 3, 1,
			0, 2, 3
	};

	public Square() {
		ByteBuffer buffer = ByteBuffer.allocateDirect(vertices.length*4);
		buffer.order(ByteOrder.nativeOrder());
		verticesBuffer = buffer.asFloatBuffer();
		verticesBuffer.put(vertices);
		verticesBuffer.position(0);
		
		colorBuffer = ByteBuffer.allocateDirect(colors.length);
		colorBuffer.put(colors);
		colorBuffer.position(0);
		
		indexesBuffer = ByteBuffer.allocateDirect(indexes.length);
		indexesBuffer.put(indexes);
		indexesBuffer.position(0);
	}
	
	public void draw(GL10 gl){
		gl.glFrontFace(GL11.GL_CW);
		gl.glVertexPointer(2, GL11.GL_FLOAT, 0, verticesBuffer);
		gl.glColorPointer(4, GL11.GL_UNSIGNED_BYTE, 0, colorBuffer);
		gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, indexesBuffer);
		gl.glFrontFace(GL11.GL_CCW);
	}
	
	
}
