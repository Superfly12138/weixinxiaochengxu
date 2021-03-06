package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.FixDao;
import com.superfly.cms.dao.RepairmanDao;
import com.superfly.cms.entity.Fix;
import com.superfly.cms.entity.Repairman;
import com.superfly.cms.service.RepairmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RepairmanServiceImpl implements RepairmanService {
    @Autowired
    private RepairmanDao repairmanDao;
    @Autowired
    private FixDao fixDao;

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
    @Transactional
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
    @Transactional
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
    @Transactional
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

    /**
     * 查询所有的维修信息
     *
     * @return
     */
    @Override
    public List<Fix> queryFixList() {
        try {
            return fixDao.queryFix();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据维修Id查询维修信息
     *
     * @param fixId
     * @return
     */
    @Override
    public Fix queryFixByFixId(Integer fixId) {
        try {
            return fixDao.queryFixByFixId(fixId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 确认完工
     *
     * @param fix 包括fixId和nextmaintain_time
     * @return
     */
    @Transactional
    @Override
    public boolean confirmFixOver(Fix fix) {
        if (fix == null) {
            throw new RuntimeException("前端传入数据无效，更新信息失败！");
        }

        if (true) {
                    try {
                        fix.setFixOver(2);
                        fix.setFixEndDate(new Date());
//                        System.out.println(fix);
                        int effectedNumber = fixDao.updateFix(fix);
                        if (effectedNumber > 0) {
                            return true;
                        } else {
                            throw new RuntimeException("确认失败！");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("确认失败！" + e.toString());
                    }
                } else {
                    throw new RuntimeException("该维修单不能确认完工！");
                }
    }


//
//    /**
//     * 接受维修单（要求存在于维修班组,前端传入的数据有，包括fixId在内的所有信息）
//     *
//     * @param fix
//     * @return
//     */
//    @Transactional
//    @Override
//    public boolean acceptFix(Fix fix) {
//        if (fix == null) {
//            throw new RuntimeException("前端传入数据无效，更新信息失败！");
//        }
//        if (fix.getRepairTeamId() != null && !"".equals(fix.getRepairTeamId())) {
//            if (fix.getRepairId() != null && !"".equals(fix.getRepairId())) {
//                if (fix.getFixOver() == 0) {
//                    try {
//                        fix.setFixStartDate(new Date());
//                        fix.setFixOver(1);
//                        int effectedNumber = fixDao.updateFix(fix);
//                        if (effectedNumber > 0) {
//                            return true;
//                        } else {
//                            throw new RuntimeException("接受维修单失败！");
//                        }
//                    } catch (Exception e) {
//                        throw new RuntimeException("接受维修单失败！" + e.toString());
//                    }
//                } else {
//                    throw new RuntimeException("不能接受改维修单！");
//                }
//            } else {
//                throw new RuntimeException("维修规定未选择！");
//            }
//        } else {
//            throw new RuntimeException("该维修人员暂未存在于维修班组，请选择维修班组后才能接收维修单！");
//        }
//
//    }
//
//    /**
//     * 完成维修单（前端传入的数据有，包括fixId在内的所有信息）
//     *
//     * @param fix
//     * @return
//     */
//    @Transactional
//    @Override
//    public boolean finishFix(Fix fix) {
//        if (fix == null) {
//            throw new RuntimeException("前端传入数据无效，更新信息失败！");
//        }
//        if (fix.getFixActualMoney() != null && !"".equals(fix.getFixActualMoney())) {
//            if (fix.getOtherCostId() != null && !"".equals(fix.getOtherCostId())) {
//                if (fix.getFixOver() == 1) {
//                    try {
//                        fix.setFixEndDate(new Date());
//                        fix.setFixOver(2);
//                        int effectedNumber = fixDao.updateFix(fix);
//                        if (effectedNumber > 0) {
//                            return true;
//                        } else {
//                            throw new RuntimeException("完成维修单失败！");
//                        }
//                    } catch (Exception e) {
//                        throw new RuntimeException("完成维修单失败！" + e.toString());
//                    }
//                } else {
//                    throw new RuntimeException("完成维修单失败！");
//                }
//            } else {
//                throw new RuntimeException("其他费用无效！");
//            }
//        } else {
//            throw new RuntimeException("维修金额无效！");
//        }
//    }
}
