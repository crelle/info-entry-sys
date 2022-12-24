package baseline.sysmgmt.controller;


import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.service.DictionaryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
@RestController
@RequestMapping("/sysmgmt/dictionary")
public class DictionaryController implements BaseController<Dictionary, DictionaryQuery> {
    @Autowired
    private DictionaryService dictionaryService;

    @Override
    public ResponseResult<Dictionary> create(Dictionary obj) {
        try {
            dictionaryService.create(obj);
        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult<Dictionary> queryById(String id) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            responseResult.setData(dictionaryService.queryById(id));
        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return responseResult;
    }

    @Override
    public ResponseResult<Page<Dictionary>> page(Page<Dictionary> pageBean) {
        try {

        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult<Page<Dictionary>> manualPage(Page<DictionaryQuery> pageBean) {
        try {

        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult<List<Dictionary>> queryAll() {
        try {

        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult<String> updateById(String id, Dictionary obj) {
        try {

        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return ResponseResult.ok();
    }

    @Override
    public ResponseResult<String> deleteById(String id) {
        try {

        } catch (Exception e) {
            return ResponseResult.fail();
        }
        return ResponseResult.ok();
    }
}
