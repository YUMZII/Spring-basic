package mybatis.dao;

import com.example.springlab.domain.MyTableDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MyTableMapper {
	@Select("select my_name, my_age from my_table")
	public List<MyTableDTO> list();
	@Insert("insert into my_table values (#{myName}, #{myAge})")
	public boolean insert(MyTableDTO visitor);
}
