<#macro pager url page>
    <div>  <ul class="pagination">
            <li class="page-item disabled">
                <span class="page-link">Страницы</span>
            </li>
            <#list 0..page.getTotalPages()-1 as p>
                <#if p == page.getNumber()>
                <li class="page-item active">
                    <a class="page-link" href="#">${p+1}</a>
                </li>
                <#else>
                    <li class="page-item">
                        <a class="page-link" href="${url}?page=${p}">${p+1}</a>
                    </li>
                </#if>
            </#list>
        </ul>
    </div>
</#macro>