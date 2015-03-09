package com.selfsystem.proxy.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.map.ObjectMapper;

import com.selfsystem.properties.PropertiesUltil;
import com.selfsystem.proxy.JoyStickRest;
import com.selfsystem.proxy.RequisicaoClienteRest;

public class ProxyClienteRest {

	private String urlBase;

	public ProxyClienteRest() {
		urlBase = PropertiesUltil.getInstance().getProperty("server.rest.url");
	}

	private HttpResponse enviarReqCliente(RequisicaoClienteRest requisicaoClienteRest, String servico) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(requisicaoClienteRest);
			HttpClient httpclient = new DefaultHttpClient();
			
			String url = urlBase + servico;
			
			HttpPost httpPost = new HttpPost(url);
			StringEntity st = new StringEntity(json);
			st.setContentType("application/json");
			st.setContentEncoding(HTTP.UTF_8);
	        httpPost.setEntity(st);

			return httpclient.execute(httpPost);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		try {
//			String url = urlBase + servico;
//			String linha = "";
//			HttpClient client = new DefaultHttpClient();
//			HttpGet requisicao = new HttpGet();
//			requisicao.setHeader("Content-Type", "text/plain; charset=utf-8");
//			requisicao.setURI(new URI(url));
//			HttpResponse resposta = client.execute(requisicao);
//			BufferedReader br = new BufferedReader(new InputStreamReader(
//					resposta.getEntity().getContent()));
//			StringBuffer sb = new StringBuffer("");
//
//			while ((linha = br.readLine()) != null) {
//				sb.append(linha);
//			}
//			br.close();
//			//return httpResponse;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}

	public void joyStickRest(final int angle, final int power, final int direction, final String stick) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				JoyStickRest joyStickRest = new JoyStickRest();
				joyStickRest.setAngle(angle);
				joyStickRest.setDirection(direction);
				joyStickRest.setPower(power);
				enviarReqCliente(joyStickRest, "keeplive");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}
}
