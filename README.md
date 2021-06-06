欢迎关注公账号，和我一起玩


![](https://files.mdnice.com/user/15648/361c6faf-118c-4a13-a1f4-66138084c46c.png)

# 代码 github 地址

https://github.com/ananananzhuo-blog/CustomViewDemo.git

# Path 中的方法

###### 1、重置 path 方法

```
 public void reset()
```

###### 2、将画笔移动到指定位置（起始位置）

这个方法的 x，y 坐标是绝对坐标

```
public void moveTo(float x, float y)
```

###### 3、将画笔移动到指定位置（起始位置）

和 2 中不同，这个方法中的 x，y 坐标是相对坐标

```
public void rMoveTo(float dx, float dy)
```

###### 4、与 2 相对应，移动 path

绝对坐标

```
 public void lineTo(float x, float y)
```

###### 5、与 3 相对应，移动 path

相对坐标

```
 public void rLineTo(float dx, float dy)
```

###### 6、二阶贝塞尔曲线

绝对坐标

x1，y1：贝塞尔曲线的控制点

x2，y2：贝塞尔曲线的终点坐标

```
public void quadTo(float x1, float y1, float x2, float y2)
```

###### 7、二阶贝塞尔曲线

相对坐标

```
 public void rQuadTo(float dx1, float dy1, float dx2, float dy2)
```

###### 8、三阶贝塞尔曲线

绝对坐标

x1、y1：三阶贝塞尔曲线第一控制点

x2、y2：三阶贝塞尔曲线第二个控制点

x3、y3：三阶贝塞尔曲线的终点

```
 public void cubicTo(float x1, float y1, float x2, float y2,
                        float x3, float y3)
```

###### 9、三阶贝塞尔曲线

相对坐标

```
 public void rCubicTo(float x1, float y1, float x2, float y2,
                         float x3, float y3)
```

###### 10、画弧线

```
 public void arcTo(RectF oval, float startAngle, float sweepAngle,
                      boolean forceMoveTo)
```

代码示例

```
 override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            path.reset()
            paint.color=Color.YELLOW
            canvas.drawCircle(250f,250f,150f,paint)
            paint.color=Color.RED
            val ovalRectf = RectF(100f, 100f, 400f, 400f)
            path.arcTo(ovalRectf, 0f, 120f)
            path.close()
            drawPath(path, paint)
        }
    }
```

实现效果：
红色部分的弧形就是我们要实现的效果，黄色部分是我们的弧形对应的整圆只起到一个参考的作用
![](https://files.mdnice.com/user/15648/1e57e510-e9a7-4a35-ad50-6c8cfaf94af9.png)

###### 11、将 path 进行偏移

偏移结果写到 dst 中

```
 public void offset(float dx, float dy, @Nullable Path dst)
```

```
public void offset(float dx, float dy)
```

###### 12、结束 path，将起点终点相连

```
public void close()
```

# 两个 path 之间的算法（Path.Op）

```
//这个方法是Path的成员方法
public boolean op(Path path, Op op)
```

下面表格是对 op 属性的说明
| 字段 | 功能 |
| --- | --- |
| DIFFERENCE | path1 减去 path2 的区域 |
| INTERSECT | 留下 path2 和 path2 相交的区域 |
| UNION | path1 和 path2 的并集 |
| XOR | 包含 path1 和 path2 但不包含相交的部分 |
| REVERSE_DIFFERENCE | path2 减去 path1 的区域 |
代码示例（分支名：path）

```
//代码所属类：PathOpView 所属分支path
override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        path2.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, radius1, Direction.CW)
            path2.addCircle(400f, 400f, radius2, Direction.CW)
            path1.op(path2, ops)
            path1.close()
            path2.close()
            canvas.drawPath(path1, paint1)
//          canvas.drawPath(path2, paint2)//这里一定不要再绘制path2了，因为path1.op(path2, ops)的存在，path2默认就会被绘制
        }
    }
```

本示例中可以通过拖动 Seekbar 改变两个圆的大小，通过点击按钮的弹窗列表框选择不同的 Path.Ops 属性查看效果

效果图：
![](https://files.mdnice.com/user/15648/439b7dd3-d710-46ec-a4bd-e2ca1c695541.gif)

# Path.Direction 方向

Path 的多个绘制方法有 Path.Direction 形参的

###### 1、 PathDirectionCCW 逆时针

示例代码

```
 path1.addRect(rect,Path.Direction.CCW)
```

###### 2、 PathDirectionCW 顺时针

示例代码

```
 path1.addRect(rect,Path.Direction.CW)
```

# Path 填充-FillType

Path 填充

FillType 是个枚举，里面有四种类型

```
 public enum FillType {

        WINDING         (0),

        EVEN_ODD        (1),

        INVERSE_WINDING (2),

        INVERSE_EVEN_ODD(3);

    }
```

## 1、WINDING

判断 path 区域是否需要被填充的方式：从该区域向外画一条射线，因为 Path 是有方向的（顺时针和逆时针 Path.Direction）。我们假设顺时针为正，逆时针为负，如果最终得到的值的绝对值大于 0 该区域就是内部区域应该被填充，如果==0 该区域为外部区域不可以被填充。所以当与射线相交的边框方向相反（一个顺时针一个逆时针）的时候就是正负得 0，该区域是外部区域不可以被填充

### 方向相同

![](https://files.mdnice.com/user/15648/b4ee4a77-c0dc-48db-8782-6521d4717d2c.png)
代码：

```

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CW)

            path1.fillType = Path.FillType.WINDING
            drawPath(path1, paint)
        }
    }
```

代码实现效果
![](https://files.mdnice.com/user/15648/0908270a-170d-42d6-91d8-0c7226a163f7.png)

### 方向相反

![](https://files.mdnice.com/user/15648/ba3905a4-3f94-4d27-bca1-753e9acd6c2e.png)

代码展示

```
 override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CCW)

            path1.fillType = Path.FillType.WINDING
            drawPath(path1, paint)
        }
    }
```

代码实现效果

![](https://files.mdnice.com/user/15648/e3d20dd8-02a3-4756-9d0e-56bef6de2bf7.png)

## 2、INVERSE_WINDING

### 方向相同

代码展示

```
 override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CW)
            path1.fillType = Path.FillType.INVERSE_WINDING
            drawPath(path1, paint)
        }
    }
```

代码实现效果展示

![](https://files.mdnice.com/user/15648/3cf52757-1d49-464a-85c1-72d06a04d7a9.png)

### 方向相反

代码展示

```
 override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CCW)
            path1.fillType = Path.FillType.INVERSE_WINDING
            drawPath(path1, paint)
        }
    }
```

代码效果展示
![](https://files.mdnice.com/user/15648/b13fbe5c-0e45-4ff9-80e0-695c8728d470.png)

## 3、EVEN_ODD

与 WINDING 相同，EVEN_ODD 也是使用画射线的方式确定是否为内部可填充区域。如果射线与 path 相交的交点数为偶数则属于外部区域，不需要被填充。如果是奇数则是内部区域，需要被填充。
效果图展示：

![](https://files.mdnice.com/user/15648/193eea44-e0ba-4e29-a17c-a825128b4833.png)

代码展示：

```
 override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CW)

            path1.fillType = Path.FillType.EVEN_ODD
            drawPath(path1, paint)
        }
    }
```

代码效果展示

![](https://files.mdnice.com/user/15648/97f21e39-7d1d-4062-b361-64c54349b6d5.png)

## 4、INVERSE_EVEN_ODD

该放手与 EVEN_ODD 被填充的区域刚好相反
代码展示

```
 override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path1.reset()
        canvas?.apply {
            path1.addCircle(200f, 200f, 100f, Path.Direction.CW)
            path1.addCircle(300f, 300f, 150f, Path.Direction.CW)

            path1.fillType = Path.FillType.INVERSE_EVEN_ODD
            drawPath(path1, paint)
        }
    }
```

代码效果展示

![](https://files.mdnice.com/user/15648/6dce3dcd-f212-44f5-9792-5075f3466c14.png)

完