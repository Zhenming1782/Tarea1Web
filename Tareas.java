import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Tareas {
    Document doc;

    Menu men = new Menu();
    String ur = men.inputURL();

    {
        try {
            doc = Jsoup.connect(ur).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parteA(){
        System.out.println("A) Cantidad de lineas: " + doc.html().split("\n").length + "\n");
    }

    public void parteB(){
        Elements p = doc.getElementsByTag("p");
        int cont =0;
        for (Element pa : p){
            cont++;
        }
        System.out.println("B) Cantidad de parrafos <p> : " +cont+ "\n");
    }

    public void parteC(){
        int cont2 =0;
        for (Element pm : doc.select("p:contains(img)")){
            pm.select("img");
            cont2++;
        }
        System.out.println("C) Cantidad de imagenes dentro de parrafos <img> : " +cont2+ "\n");

    }

    public void parteD(){
        Elements frm = doc.getElementsByTag("form");
        Elements fem = doc.getElementsByAttributeValue("method","post");
        Elements fom = doc.getElementsByAttributeValue("method","get");

        int POST =0;
        int GET =0;

            for (Element fm2 : fem){
                POST++;
            }


            for (Element fm3 : fom){
                GET++;
            }

        System.out.println("D) Cantidad de formularios <POST> : " +POST+ "\n");
        System.out.println("D) Cantidad de formularios <GET> : " +GET+ "\n");
    }
    public void parteE(){
        Elements fm = doc.select("form");
        for (Element fma : fm) {
         fma.select("input[type]");
        }
        System.out.println("E) Form campos input y su respectivo tipo : " +fm+ "\n");
    }

    public void parteF(){
        Elements fm = doc.select("form");
        for (Element fma : fm) {
            if(fma.attr("method").equals("post")){
                try {
                    Connection.Response resp = Jsoup.connect(ur)
                            .method(Connection.Method.POST)
                            .data("asignatura", "practica1")
                            .header("Matricula", "20150069")
                            .execute();

                    System.out.println("Respuesta del servidor codigo: "+resp.statusCode() +"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
