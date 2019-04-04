package com.superfly.cms.web;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.superfly.cms.entity.Area;
import com.superfly.cms.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 获取所有的区域信息
     *
     * @return
     */

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap =  new HashMap<String,Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
//        modelMap.put("success","succe");
        return modelMap;
    }

    /**
     * 通过区域Id获取区域信息
     *
     * @return
     */
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @param
     * @param
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     *
     * @param
     * @param
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}
