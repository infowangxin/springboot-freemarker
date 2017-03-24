<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>示例</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="icon" type="image/x-icon" href="${ctx}/static/images/favicon.ico">
<link rel="shortcut icon" type="image/x-icon" href="${ctx}/static/images/favicon.ico">

<c:set var="version_css" value="20131213" scope="application"></c:set>
<c:set var="version_js" value="20131213" scope="application"></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link href="<c:url value='/static/jquery/themes/base/jquery-ui.min.css?${version_css}'/>" rel="stylesheet" type="text/css" />
<link href="${ctx}/static/bootstrap/css/bootstrap.min.css?${version_css}" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/bootstrap/css/bootstrap-theme.min.css?${version_css}" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/jquery/plugins/css/jquery.scrollToTop.css?${version_css}" type="text/css" rel="stylesheet" />
<link href="${ctx}/static/css/default.css?${version_css}" type="text/css" rel="stylesheet" />

<script src="${ctx}/static/jquery/jquery-1.9.1.js?${version_js}" type="text/javascript"></script>
<script src="<c:url value='/static/jquery/ui/jquery-ui.custom.min.js?${version_js}'/>" type="text/javascript"></script>
<script src="<c:url value='/static/jquery/ui/jquery.ui.datepicker.min.js?${version_js}'/>" type="text/javascript"></script>
<script src="<c:url value='/static/jquery/ui/i18n/jquery.ui.datepicker-zh-CN.min.js?${version_js}'/>" type="text/javascript"></script>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js?${version_js}" type="text/javascript"></script>
<script src="${ctx}/static/js/common.js?${version_js}" type="text/javascript"></script>
<script src="${ctx}/static/jquery/plugins/js/jquery.scrollToTop.js?${version_js}" type="text/javascript"></script>
<script type="text/javascript">
  var _ctx = "${pageContext.request.contextPath}";
  jQuery(function() {
    jQuery(window).scrollToTop();
  });
</script>
<!--[if lt IE 9]>
<script src="${ctx}/static/bootstrap/js/html5shiv.js"></script>
<script src="${ctx}/static/bootstrap/js/respond.min.js"></script>
<![endif]-->
<script src="${ctx}/static/js/news/news.js?${version_js}" type="text/javascript"></script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp"%>
		<div class="container">
			<div id="content">
				<form action="${ctx }/news" id="newsForm" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">标题：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="title" id="title" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">内容：</label>
						<div class="col-sm-4">
							<textarea class="form-control" name="description" id="description" row="15"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-2 control-label">地址：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="address" id="address" />
						</div>
					</div>

					<div class="form-group">
						<label for="newsTime" class="col-sm-2 control-label">发生时间：</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="newsTime" id="newsTime" readonly="readonly" />
						</div>
					</div>


					<div class="form-group input-group-sm">
						<label class="col-sm-2 control-label">&nbsp;</label>
						<div class="col-sm-2">
							<button class="btn btn-default" type="button" id="saveBtn">保存</button>
							<button class="btn btn-default" type="reset">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>

