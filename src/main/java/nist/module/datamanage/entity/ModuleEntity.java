package nist.module.datamanage.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_module")
public class ModuleEntity extends PageEntity {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Id
    private String jlbh;
    private String parentId;
    private String name;
    private String url;
    private String createTime;

    public String getJlbh() { return jlbh; }

    public void setJlbh(String jlbh) { this.jlbh = jlbh; }

    public String getParentId() { return parentId; }

    public void setParentId(String parentId) { this.parentId = parentId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getCreateTime() { return createTime;}

    public void setCreateTime(String createTime) { this.createTime = createTime; }
}
