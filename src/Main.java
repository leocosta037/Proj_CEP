public class Main {

	public static void main(String[] args) {
		String cep = "01255000";
		
		String retorno = postRequest.getRequest().requisicao(cep);
		
	}
}