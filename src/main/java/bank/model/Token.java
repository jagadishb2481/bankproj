package bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Token {

		@Id
	    @GeneratedValue
	    private int id;
		@NotBlank
	    private String service;
	    private String status;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getService() {
			return service;
		}
		public void setService(String service) {
			this.service = service;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Token() {
			
			// TODO Auto-generated constructor stub
		}
		public Token(int id, String service, String status) {
			super();
			this.id = id;
			this.service = service;
			this.status = status;
		}
		@Override
		public String toString() {
			return "Token [id=" + id + ", service=" + service + ", status=" + status + "]";
		}
	    
}
