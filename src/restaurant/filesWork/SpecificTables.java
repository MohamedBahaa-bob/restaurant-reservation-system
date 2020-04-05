package restaurant.filesWork;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reserved_tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecificTables {@XmlElement(name="reserved_table")
List<SpecificTable> spTables=null;

public List<SpecificTable> getSpTables() {
return spTables;
}

public void setSpTables(List<SpecificTable> spTables) {
this.spTables = spTables;
}

}
