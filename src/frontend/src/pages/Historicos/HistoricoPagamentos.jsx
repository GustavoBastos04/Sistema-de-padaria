import {Table} from "react-bootstrap";
import ItemPagamento from "../../components/ListItems/ItemPagamento";

function HistoricoPagamentos() {
    return (
        <div>
            <Table className="striped bordered hover">
                <thead>
                    <tr>
                        <th>CPF do cliente</th>
                        <th>Forma de pagamento</th>
                    </tr>
                </thead>
                <tbody>
                    <ItemPagamento cpf_cliente="123.456.789-11" forma="Pix"/>
                </tbody>
            </Table>
        </div>
    )
}

export default HistoricoPagamentos