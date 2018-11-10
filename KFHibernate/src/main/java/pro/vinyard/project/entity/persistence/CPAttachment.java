package pro.vinyard.project.entity.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Entity
@Table(name="Attachment")
public class CPAttachment {
	
	private static Logger logger = LoggerFactory.getLogger(CPAttachment.class);
	
	
	@Id
	@GeneratedValue
	private long id;
	
	private String type;
	
	private byte[] byteArray;
	
	@Transient
	private BufferedImage image;
	
	public CPAttachment(String type, byte[] byteArray) {
		this.type = type;
		this.byteArray = byteArray;
	}
	
	public CPAttachment() {
		// default constructor
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
			logger.info("ImageIO read error", e);
		}
		
		return this.image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
