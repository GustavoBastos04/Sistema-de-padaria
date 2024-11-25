import PropTypes from 'prop-types'
import { Modal, Card }  from 'react-bootstrap'
function ProfitModal({show, onClose, props}) {

    return(
        <div>
            <Modal show={show} fullscreen={true} onHide={onClose}>
                <Modal.Header closeButton>
                <Modal.Title>Lucro do produto {props.nome} </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                <Card className="shadow mb-4">
                    <Card.Body>
                        <Card.Title className="text-center">Receita gerada até o momento</Card.Title>
                        <Card.Text className='text-center'> R$50,00</Card.Text>
                    </Card.Body>
                </Card>
                <Card className="shadow mb-4">
                    <Card.Body>
                        <Card.Title className="text-center">Custo total do produto</Card.Title>
                        <Card.Text className='text-center'> R$100,00</Card.Text>
                    </Card.Body>
                </Card>
                <Card className="shadow mb-4">
                    <Card.Body>
                        <Card.Title className="text-center">Lucro estimado para do produto</Card.Title>
                        <Card.Text className='text-center'> - R$50,00</Card.Text>
                    </Card.Body>
                </Card>
                </Modal.Body>
            </Modal>
        </div>
    )
}

ProfitModal.propTypes = {
    show: PropTypes.bool.isRequired,
    onClose: PropTypes.func.isRequired,
    nome: PropTypes.string.isRequired,
}
export default ProfitModal