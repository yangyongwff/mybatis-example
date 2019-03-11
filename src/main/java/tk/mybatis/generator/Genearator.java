package tk.mybatis.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class Genearator {
	
	public static void main(String[] args) throws Exception  {
		
		List<String> warnings = new ArrayList<>();
		boolean overwrite = true;  //当生成的代码重复时，覆盖原代码
		
		//读取MBG配置文件
		InputStream iStream = Genearator.class.getResourceAsStream("/generator/generatorConfig.xml");
		ConfigurationParser configurationParser = new ConfigurationParser(warnings);
		Configuration config = configurationParser.parseConfiguration(iStream);
		iStream.close();
		
		DefaultShellCallback dCallback = new DefaultShellCallback(overwrite);
		
		//创建MBG
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, dCallback, warnings); 
		
		myBatisGenerator.generate(null);
		for(String warning : warnings) {
			System.out.println(warning);
		}
		
	}

}
