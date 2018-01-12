package main.snnu.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WT on 2017/12/30.
 */
public class ScanXml {
    private static Map<String,String> stringMap = new HashMap<>();
    public static Map<String,String> getStringMap(){
        if(stringMap.isEmpty()){
            ScanXml scanXml= new ScanXml();
            scanXml.Scan();
        }
        return stringMap;
    }
    public void Scan(){
        // 创建DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Map<String,String> map = null;
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            String path = this.getClass().getClassLoader().getResource("").getPath();
            path = path + "main" + File.separator + "snnu" + File.separator + "myXml.xml";
            //通过documentBuilder对象 的parser方法加载books。xml文件到当前项目下
            Document document = db.parse(path);
            //获取所有bean节点的集合
            NodeList booklist = document.getElementsByTagName("bean");
            //遍历每一个book节点
            for(int i= 0; i<booklist.getLength();i++){
                map =new HashMap<>();
                //通过item(i)方法获取bean节点
                Node book = booklist.item(i);
                //获取bean节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                //遍历bean的属性
                for(int j = 0;j<attrs.getLength();j++){
                    //通过item方法获取bean节点的属性
                    Node attr = attrs.item(j);
                    map.put(attr.getNodeName(),attr.getNodeValue());
                }
                stringMap.put(map.get("name"),map.get("class"));
                NodeList chilNod = book.getChildNodes();
                for(int k = 0;k<chilNod.getLength();k++){
                    map.clear();
                    Node chil = chilNod.item(k);
                    //区分text 类型node
                    if(chilNod.item(k).getNodeType() == Node.ELEMENT_NODE){
                        NamedNodeMap attrs1 = chil.getAttributes();
                        for(int j = 0;j<attrs1.getLength();j++) {
                            Node attr2 = attrs1.item(j);
                            //获取属性名
                            map.put(attr2.getNodeName(),attr2.getNodeValue());
                        }
                        stringMap.put(map.get("attr"),map.get("name"));
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        System.out.println(ScanXml.getStringMap());
    }
}
