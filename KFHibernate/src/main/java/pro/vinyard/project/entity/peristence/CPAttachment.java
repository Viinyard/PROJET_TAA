package pro.vinyard.project.entity.peristence;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Entity
public class CPAttachment {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String type;
	
	private byte[] byteArray;
	
	@Transient
	private BufferedImage image;
	
	public CPAttachment(long id, String type, byte[] byteArray) {
		super();
		this.id = id;
		this.type = type;
		this.byteArray = byteArray;
	}
	
	public CPAttachment(String type, byte[] byteArray) {
		super();
		this.type = type;
		this.byteArray = byteArray;
	}
	
	public CPAttachment() {
	
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public byte[] getByteArray() {
		return byteArray;
	}
	
	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}
	
	public BufferedImage getImage() {
		if(this.image != null) return this.image;
		
		InputStream in = new ByteArrayInputStream(this.getByteArray());
		
		try {
			this.image = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
