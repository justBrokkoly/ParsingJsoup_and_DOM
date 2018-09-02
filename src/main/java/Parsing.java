import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parsing {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File file = new File("file.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Element empoyersElement =(Element) document.getElementsByTagName("employers").item(0);
        String department = empoyersElement.getAttribute("department");

        NodeList employeesNodelList = document.getElementsByTagName("employee");

        List<Employee> employeeList = new ArrayList<Employee>();

        for(int i=0; i<employeesNodelList.getLength();i++){
            if(employeesNodelList.item(i).getNodeType()== Node.ELEMENT_NODE){
                Element employeeElement = (Element)employeesNodelList.item(i);

                Employee employee = new Employee();
                employee.setDepartment(department);
                employee.setNumber(Integer.valueOf(employeeElement.getAttribute("number")));

                String name = employeeElement.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                employee.setName(name);

                Integer age =Integer.valueOf(employeeElement.getElementsByTagName("age").item(0).getChildNodes().item(0).getNodeValue());
                employee.setAge(age);

                Double value =Double.valueOf(employeeElement.getElementsByTagName("salary").item(0).getChildNodes().item(0).getNodeValue());
                employee.getSalary().setValue(value);
               // String currency = employeeElement.getElementsByTagName("salary").item(0).getChildNodes().item(0).getAttributes().getNamedItem("currency").getNodeValue();

                String b =employeeElement.getElementsByTagName("salary").item(0).getAttributes().getNamedItem("currency").getNodeValue();

                employee.getSalary().setCurrency(b);


              /*  NodeList childNodes = employeeElement.getChildNodes();
                for(int j=0; j <childNodes.getLength();j++){
                    if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){
                        Element childElement = (Element)childNodes.item(j);

                        switch (childElement.getNodeName()){
                            case "name" : {
                                employee.setName(childElement.getTextContent());
                            }break;

                            case "age" : {
                                employee.setAge(Integer.valueOf(childElement.getTextContent()));
                            }break;

                            case "salary" : {
                                employee.getSalary().setValue(0.00);
                                employee.getSalary().setCurrency(childElement.getAttribute("currency"));
                            }
                        }
                    }
                }*/

                employeeList.add(employee);

            }
        }

        employeeList.forEach(System.out::println);

    }
}
