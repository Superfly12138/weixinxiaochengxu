package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.RepairTeamDao;
import com.superfly.cms.dao.RepairmanDao;
import com.superfly.cms.entity.Repairman;
import com.superfly.cms.service.RepairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RepairmanServiceImpl implements RepairmanService {
    @Autowired
    private RepairmanDao repairmanDao;
    /**
     * 根据维修人员Id获取维修人员信息
     *
     * @param repairmanId
     * @return Repairman
     */
    @Override
    public Repairman getRepairmanById(Integer repairmanId) {
        try {
            return repairmanDao.queryRepairmanById(repairmanId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 注册
     *
     * @param repairman
     * @return success:true else:false
     */
    @Override
    public boolean addRepairman(Repairman repairman) {
        if (repairman == null) {
            throw new RuntimeException("前端传入数据无效，添加客户失败！");
        }
        //判断插入的数据是否为空
        if (repairman.getRepairmanName() != null && !"".equals(repairman.getRepairmanName())) {
            if (repairman.getRepairmanPassword() != null && !"".equals(repairman.getRepairmanPassword())) {
                if (repairman.getRepairmanSex() != null && !"".equals(repairman.getRepairmanSex())) {
                    if (repairman.getRepairmanAge() != null) {
                        if (repairman.getRepairmanPhone() != null && !"".equals(repairman.getRepairmanPhone())) {
                            if (repairman.getRepairmanAddress() != null && !"".equals(repairman.getRepairmanAddress())) {
                                if (repairman.getRepairmanEmail() != null && !"".equals(repairman.getRepairmanEmail())) {
                                    //设置注册时间
                                    repairman.setRepairmanRegistrationDate(new Date());
                                    try {
                                        int effectedNumber = repairmanDao.insertRepairman(repairman);
                                        if (effectedNumber > 0) {
                                            return true;
                                        } else {
                                            throw new RuntimeException("用户注册失败！");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException("用户注册失败！" + e.toString());
                                    }

                                } else {
                                    throw new RuntimeException("邮箱不能为空！");
                                }
                            } else {
                                throw new RuntimeException("地址不能为空！");
                            }
                        } else {
                            throw new RuntimeException("手机号不能为空！");
                        }
                    } else {
                        throw new RuntimeException("年龄不能为空！");
                    }
                } else {
                    throw new RuntimeException("性别不能为空！");
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    /**
     * 通过姓名登录
     *
     * @param repairmanName
     * @param repairmanPassword
     * @return success:true else:false
     */
    @Override
    public boolean loginRepairmanByName(String repairmanName, String repairmanPassword) {
        if (repairmanName != null && !"".equals(repairmanName)) {
            if (repairmanPassword != null && !"".equals(repairmanPassword)) {
                try {
                    //通过姓名登录获取password（只有一个用户名时才有效）
                    List<Repairman> list = repairmanDao.queryRepairmanByName(repairmanName);
                    if (list.size() < 1) {
                        throw new RuntimeException("姓名不存在！");
                    } else if (list.size() == 1) {
                        if (list.get(0).getRepairmanPassword().equals(repairmanPassword)) {
                            return true;
                        } else {
                            throw new RuntimeException("密码错误！");
                        }
                    } else {
                        throw new RuntimeException("姓名存在重复，请使用其他方式登录！");
                    }

                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    /**
     * 通过手机登录
     *
     * @param repairmanPhone
     * @param repairmanPassword
     * @return success:true else:false
     */
    @Override
    public boolean loginRepairmanByPhone(String repairmanPhone, String repairmanPassword) {
        if (repairmanPhone != null && !"".equals(repairmanPhone)) {
            if (repairmanPassword != null && !"".equals(repairmanPassword)) {
                try {
                    //通过手机号登录获取password
                    if (repairmanDao.queryRepairmanByPhone(repairmanPhone) == null) {
                        throw new RuntimeException("手机号不存在！");
                    } else if (repairmanDao.queryRepairmanByPhone(repairmanPhone).getRepairmanPassword().equals(repairmanPassword)) {
                        return true;
                    } else {
                        throw new RuntimeException("密码错误！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("手机号不能为空！");
        }
    }

    /**
     * 通过邮箱登录
     *
     * @param repairmanEmail
     * @param repairmanPassword
     * @return success:true else:false
     */
    @Override
    public boolean loginRepairmanByEmail(String repairmanEmail, String repairmanPassword) {
        if (repairmanEmail != null && !"".equals(repairmanEmail)) {
            if (repairmanPassword != null && !"".equals(repairmanPassword)) {
                try {
                    //通过邮箱登录获取password
                    if (repairmanDao.queryRepairmanByEmail(repairmanEmail) == null) {
                        throw new RuntimeException("邮箱不存在！");
                    } else if (repairmanDao.queryRepairmanByEmail(repairmanEmail).getRepairmanPassword().equals(repairmanPassword)) {
                        return true;
                    } else {
                        throw new RuntimeException("密码错误！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("邮箱不能为空！");
        }
    }

    /**
     * 修改维修人员信息
     *
     * @param repairman
     * @return success:true else:false
     */
    @Override
    public boolean modifyRepairman(Repairman repairman) {
        if (repairman == null) {
            throw new RuntimeException("前端传入数据无效，添加客户失败！");
        }
        if (repairman.getRepairmanName() != null && !"".equals(repairman.getRepairmanName())) {
            if (repairman.getRepairmanPassword() != null && !"".equals(repairman.getRepairmanPassword())) {
                if (repairman.getRepairmanSex() != null && !"".equals(repairman.getRepairmanSex())) {
                    if (repairman.getRepairmanAge() != null) {
                        if (repairman.getRepairmanPhone() != null && !"".equals(repairman.getRepairmanPhone())) {
                            if (repairman.getRepairmanAddress() != null && !"".equals(repairman.getRepairmanAddress())) {
                                if (repairman.getRepairmanEmail() != null && !"".equals(repairman.getRepairmanEmail())) {

                                    try {
                                        int effectedNumber = repairmanDao.updateRepairman(repairman);
                                        if (effectedNumber > 0) {
                                            return true;
                                        } else {
                                            throw new RuntimeException("更新失败！");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException("更新失败！" + e.toString());
                                    }

                                } else {
                                    throw new RuntimeException("邮箱不能为空！");
                                }
                            } else {
                                throw new RuntimeException("地址不能为空！");
                            }
                        } else {
                            throw new RuntimeException("手机号不能为空！");
                        }
                    } else {
                        throw new RuntimeException("年龄不能为空！");
                    }
                } else {
                    throw new RuntimeException("性别不能为空！");
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    /**
     * 注销维修人员信息
     *
     * @param repairmanId
     * @return success:true else:false
     */
    @Override
    public boolean deleteRepairman(Integer repairmanId) {
        try {
            //删除用户
            int effectedNum = repairmanDao.deleteRepairman(repairmanId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("注销用户失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("注销用户失败:" + e.toString());
        }
    }
}
