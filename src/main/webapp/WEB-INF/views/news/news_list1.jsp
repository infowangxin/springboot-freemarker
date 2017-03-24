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
<script src="${ctx}/static/js/news/news_list1.js?${version_js}" type="text/javascript"></script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp"%>
		<div class="container">
			<div id="content">
				<form class="form-horizontal">
					<div class="form-group">
						<div class="col-sm-4">
							<input type="text" class="form-control" name="keywords" id="keywords" />
						</div>
						<div class="col-sm-2">
							<button class="btn btn-default" type="button" id="searchBtn">搜索</button>
						</div>
					</div>
				</form>
				<div class="row">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th>标题</th>
								<th>内容</th>
								<th>发生时间</th>
								<th>创建时间</th>
								<th>地址</th>
							</tr>
						</thead>
						<tbody id="newsBody">

						</tbody>
					</table>
				</div>

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>

