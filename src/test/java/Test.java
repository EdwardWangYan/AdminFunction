import com.wy.integration.dto.AddDeatilsUpdate.SysResourceAddUpdateDto;
import com.wy.integration.model.SysResource;
import com.wy.integration.utils.ToolUtil;

public class Test {

    public static void main(String args[]) throws IllegalAccessException, InstantiationException {
        SysResourceAddUpdateDto emp2 = SysResourceAddUpdateDto.class.newInstance();
        emp2.setId("test");
        SysResource re=(SysResource) ToolUtil.copyProperties(emp2,SysResource.class);
        System.out.println(re.getId());
    }
}
