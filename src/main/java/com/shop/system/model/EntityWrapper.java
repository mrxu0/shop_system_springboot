package com.shop.system.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;

public class EntityWrapper<T> extends Wrapper {
    @Override
    public Object getEntity() {
        return null;
    }

    @Override
    public MergeSegments getExpression() {
        return null;
    }

    @Override
    public String getSqlSegment() {
        return null;
    }
}
